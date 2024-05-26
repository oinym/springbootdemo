#!/bin/bash
http -v GET :8081/api/runs --pretty=format


http -v GET :8081/api/runs/1  --pretty=format

http -v GET :8081/api/runs/2 --pretty=format

http -v GET :8081/api/runs/3 --pretty=format

http -v POST :8081/api/runs id=3 title='afternoon run' startedOn='2024-05-26T12:00:00.00000' completedOn="2024-05-26T14:00:00.00000" miles=10 location=INDOOR --pretty=format

