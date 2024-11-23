FROM ubuntu:latest
LABEL authors="Saurabh Srivastav"

ENTRYPOINT ["top", "-b"]



EXPOSE 8080