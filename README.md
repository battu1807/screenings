
**demo** application contains 3 API definitions as below. 
<pre>
1. <b>To save Employee Data</b>
   <i>POST http://localhost:8080/api/employee </i>
  
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

2. <b>API to get tax information of a specific employee</b>
   <i>GET http://localhost:8080/api/tax/{employeeId}</i>

  Response:
  {
    "employeeId": 1,
    "firstName": "Rudra",
    "lastName": "Satya",
    "salary": 203000,
    "taxAmount": 424952.8,
    "cessAmount": 0.0
  }
  
3. <b>To get tax information of all employees</b>
   <i>GET http://localhost:8080/api/tax</i>

  Response:
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


I have used Hashtable data structure to store Employee data as temporary. At the same place we can use any Database repository logic to save data persistantly
</pre>
