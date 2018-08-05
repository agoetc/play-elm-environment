build:
	docker-compose down
	docker-compose build
	docker-compose up -d
	cd ./slick-codegen; \
		./sbt.sh gen-tables
	cd ./play-scala-seed; \
		elm-package install -y

up:
	docker-compose down
	docker-compose build
	docker-compose up -d

down:
	docker-compose down
