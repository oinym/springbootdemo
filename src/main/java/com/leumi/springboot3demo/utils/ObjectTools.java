package com.leumi.springboot3demo.utils;

import java.lang.reflect.Field;

public class ObjectTools {
  public static void updateObject(Object obj, String[] updates) {
    if (updates.length % 2 != 0) {
      throw new IllegalArgumentException("Updates array length must be even");
    }

    try {
      Class<?> clazz = obj.getClass();
      for (int i = 0; i < updates.length; i += 2) {
        String fieldName = updates[i];
        String newValue = updates[1 + i];
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true); // Might throw SecurityException

        // Check field type compatibility before setting the value
        Class<?> fieldType = field.getType();
        if (fieldType.equals(String.class)) {
          field.set(obj, newValue);
        } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
          field.setInt(obj, Integer.parseInt(newValue));
        } else if (fieldType.equals(double.class)) {
          field.setDouble(obj, Double.parseDouble(newValue));
        } else {
          // Handle other primitive types or throw an exception for unsupported types
          throw new IllegalArgumentException("Unsupported field type: " + fieldType);
        }
      }
    } catch (NoSuchFieldException | SecurityException | IllegalAccessException | NumberFormatException e) {
      throw new RuntimeException("Error updating object: " + e.getMessage(), e);
    }
  }

}
