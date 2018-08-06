up:
	docker-compose down
	docker-compose build
	docker-compose up -d

build:
	cd ./slick-codegen; \
		./sbt.sh gen-tables
	cd ./play-scala-seed; \
		elm-package install -y

down:
	docker-compose down
