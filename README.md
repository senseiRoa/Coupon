<h1 align="center">Welcome to coupon 👋</h1>
<p>
 
  <a href="tarjet//dd" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://twitter.com/Andre\_Roa\_G" target="_blank">
    <img alt="Twitter: Andre\_Roa\_G" src="https://img.shields.io/twitter/follow/Andre\_Roa\_G.svg?style=social" />
  </a>
</p>

> Challenge Tecnico MercadoLibre

### 🏠 Homepage

Api that allows a list of items and a value assigned by a voucher to be passed through parameters internally verifies which is the list that optimizes the number of products and does not exceed the amount of the voucher

The project is created with Spring Boot, Java 8, Maven and netbeans development.




### ✨ [AWS DEMO API](http://ec2-18-222-150-7.us-east-2.compute.amazonaws.com/)

The service is deployed in an EC2-AWS instance in a virtual machine with Ubuntu server v20, which has docker and JAVA installed.

*The public IP is:18.222.150.7

*The DNS is: ec2-18-222-150-7.us-east-2.compute.amazonaws.com

*The port is :80


## Deploy with spring boot

To run in the development environment of the project, a terminal must be opened in the root of the project and execute the following maven commands:

```sh
    ./mvnw clean package 
    ./mvnw spring-boot:run 
```

## Deploy with docker 

To deploy the project in a docker container, go to the root of the project and run the following commands:

```sh
    ./mvnw clean package 
    docker-compose up -d --build 
```

## Routes
The project was deployed by port 8080
and It has a single EndPoint of type POST

```sh
* post  /api/coupon/
```

The service expects a json object with the following structure

```json
    {
    "item_ids": ["MLA917496925","MLA927496925","MLA927496915","MLA927296925","MLA927296821","MLA917286821","MLA927286823","MLA827283824"],
    "amount": 3500
    }

```
And finally it returns the list of items with the following structure

```json
  {
    "item_ids": [
        "MLA927296821",
        "MLA917286821",
        "MLA927286823"
    ],
    "total": 1837.0
}

```

## Author

👤 **Fabio Andres Roa Garcia**

* Website:  https://www.linkedin.com/in/andres-roa-garcia-74324160/
* Twitter: [@Andre\_Roa\_G](https://twitter.com/Andre\_Roa\_G)
* Github: [@SenseiRoa](https://github.com/SenseiRoa)
* LinkedIn: [@andres-roa-garcia-74324160](https://www.linkedin.com/in/andres-roa-garcia-74324160/)

### Show your support

Give a ⭐️ if this project helped you!

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
