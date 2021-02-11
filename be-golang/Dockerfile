FROM golang as builder
RUN apt-get update && apt-get -y install git make gcc linux-libc-dev \
    && mkdir -p /build/monorepo

WORKDIR /build/monorepo
COPY src /build/monorepo
RUN go build -o be-golang

FROM golang
RUN mkdir -p /app \
    && mkdir -p /data \
    && apt-get update && apt-get install gcc
WORKDIR /app
COPY --from=builder /build/monorepo/be-golang .
ENTRYPOINT ["/app/be-golang"]