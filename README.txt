Customer Reward Application - 

build the application - 
mvn clean install

running jar - 
java -jar customer-reward-1.0.0.jar

Three tables - 
1. customer
2. customer_transaction
3. customer_reward

API - 
1. to create new customer - 
	http://localhost:8081/customer/newCustomer
	request - 
		{
    		"name" : "Aman Saxena",
    		"email" : "aman.saxena05@infosys.com",
    		"phoneNumber": "9739698023"
		}

post mapping

2. Get Customer - 
	http://localhost:8081/customer/getCustomer/{customerId}
	Get Mapping

3. Create New Transaction - 
	http://localhost:8081/transaction/newTransaction
	request - 
	{
    "date" : "2024-10-24",
    "amount" : 215,
    "spentDetails": "Dress",
    "customerId" : "75b145df-9956-4cbf-96c3-954b3757c9e9"
	}

PostMapping

4. Get Customer Details with Reward- 
	http://localhost:8081/rewardPoints/getByCustomerId/{customerId}
GetMapping


Swagger link - http://localhost:8081/swagger-ui/index.html


SQL - 
create table customer(id varchar(50) primary key, name varchar(50), email varchar(50), phone_number varchar(50));

create table customer_transaction(
	id varchar(50) primary key, 
    transaction_date datetime,
    amount int,
    spent_details varchar(50),
    customer_id varchar(50),
    foreign key (customer_id) references customer(id));

create table reward_points(
	id varchar(50) primary key,
    transaction_month int,
    transaction_year int,
    points int,
    customer_id varchar(50),
    foreign key (customer_id) references customer(id)
);

