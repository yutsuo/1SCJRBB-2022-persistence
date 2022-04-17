FROM mongo:latest

COPY ./seed /
COPY startup.sh /
RUN chmod +x ./startup.sh

CMD ./startup.sh