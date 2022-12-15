FROM node:14-bullseye-slim
ENV NODE_ENV=production
WORKDIR /app
COPY "./src/package.json" "./"
RUN npm install --production
COPY /src /app
EXPOSE 8080
CMD [ "node", "server.js" ]
