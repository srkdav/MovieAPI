
<!-- PROJECT SHIELDS -->
<!-- PROJECT LOGO -->
<br />
<p align="center">
 
  <h3 align="center">Movie REST API</h3>

  <p align="center">
   The REST API processes and returns the count and the list of movies that he must act in for maximum salary.  
    <br />
   </p>
</p>

### Built With
   * Java 8 in Spring Boot  

### BackGround  
           
The REST API has been implemented according to MVC structure. The Controller contains the paths and its individual methods. 
The Service Layer contains the business logic to process the data according to the requirement. I have further granulated the strucure to ensure loose coupling
by using Helper class. 


### Commands to run  
            
1) Clone the repository to a "Projects" folder.
2) Open the project "MoviesAPI" in Eclipse/STS3/STS4 preferably.
3) Please update the project in case of any discrepency. 

 
### Process to get the Json data in desired format
1) Please POST the data as : "http://localhost:8080/movie/SetMovieList" , data will be received in the format as desired format (count and movie list).

Movie List JSON DATA : 
  ```json
{
    "list": [
        {
            "name": "Bala",
            "from": "2020-01-08",
            "to": "2020-01-28"
        },
        {
            "name": "Rock",
            "from": "2020-01-20",
            "to": "2020-01-30"
        },
        {
            "name": "PolicyMaker",
            "from": "2020-01-29",
            "to": "2020-02-16"
        },
        {
            "name": "Brave",
            "from": "2020-02-02",
            "to": "2020-02-14"
        },
        {
            "name": "Drive",
            "from": "2020-02-10",
            "to": "2020-02-18"
        },
        {
            "name": "Race",
            "from": "2020-02-15",
            "to": "2020-02-28"
        }
    ]
}
```

                 
                  
