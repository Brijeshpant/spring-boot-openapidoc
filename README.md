
User story 1: Create a user with firstName,lastName,middleName,email
====================================================
1. Users's firstName, lastName, email cannot be empty
2. User email should be unique
3. User email should follow email pattern 

Input: 
      
      firstName, lastName, middleName, email

Output:

         Id of newly created user
 
 
- Path :  /api/users

- Method:  Post  
  
 
      
  
  Failure: 
  - Bad request:400 
      `{"errors":["firstName","lastName"], "message":"Invalid fields"}`
  - Internal server error:503
             `{"code":"503", "message":"Internal server error"}`
  - User already exists:500
            `{"code":"500", "message":"User already exists"}`
    
  Success: 
  - {id: "1234"}  :201
