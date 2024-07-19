
**demo** application contains 3 API definitions as below. 

1. **To save Employee Data**
   **POST localhost:8080/api/employee**
   Sample Request Body :
   {
    "employeeId": 2,
    "firstName": "Rudra",
    "lastName": "Satya",
    "email": "rudra@gmail.com",
    "phoneNumber": 1234567890,
    "salary": 203000,
    "doj": "2023-05-16"
  }
  Response:
  {
      "employeeId": 1,
      "firstName": "Rudra",
      "lastName": "Satya",
      "email": "rudra@gmail.com",
      "phoneNumber": 1234567890,
      "salary": 203000,
      "doj": "2023-05-16"
  }

2. **API to get tax information of a specific employee**
**GET localhost:8080/api/tax/{employeeId}**
Response:
{
    "employeeId": 1,
    "firstName": "Rudra",
    "lastName": "Satya",
    "salary": 203000,
    "taxAmount": 424952.8,
    "cessAmount": 0.0
}
3. **To get tax information of all employees**
 ** GET localhost:8080/api/tax**

[
    {
        "employeeId": 2,
        "firstName": "Rudra",
        "lastName": "Satya",
        "salary": 203000,
        "taxAmount": 424952.8,
        "cessAmount": 0.0
    },
    {
        "employeeId": 1,
        "firstName": "Rudra",
        "lastName": "Satya",
        "salary": 203000,
        "taxAmount": 424952.8,
        "cessAmount": 0.0
    }
]


I have used Hashtable data structure to store Employee data as temporary. At the same place we can user any Database repository logic to save data persistantly
