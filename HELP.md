# Getting Started

### Build the application
mvn clean install
docker build -t gcretro/docker-demo-<n> .
docker push gcretro/docker-demo-<n>
docker run -p 8080:8080 gcretro/docker-demo-<n> .

docker image ls
docker container ls
