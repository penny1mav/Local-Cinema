<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

 <style>
* {
box-sizing: border-box;
font-family: "Lucida Sans", sans-serif;

}



.header {
color: rgb(0, 0, 0);
display: inline-block;
text-align: center;
width:100%;

}


.bg {
	
color: slategrey;
width: 100%;
background-image: url("tester/WebContent/back4.png");
text-align: center;
font-size: 25px;
}

.logo {
width: 7%;

}
.rights{
background-color: MediumSlateBlue;
color: black;
text-align: center;
width:100%;
margin-top: 8%;
padding-bottom:1%;

}
.rights2{
color: brown;
width:100%;
margin: 0%;

}

.media{
margin: 0%;
display: inline-block;
text-align: right;
font-size:20px;
background-color: MediumSlateBlue;
width:100%;
color: white;



}


.footer {
width: 100%;
padding: 0%;
text-align: left;
display: inline-block;


font-size: 25px;
}

.media img{
width:30px;
height:30px;
border-radius: 5px;
}


a:link,
a:visited {
text-align: center;
display: inline-block;
padding: 15px ;
color: black;
text-decoration: none;
}

a:hover,
a:active {

cursor: pointer;

}

.rows {
padding: 10px;
font-size: 2px;
width: 100%;
display: flex;

}

.register {
text-align: center;
width: 100%;
padding: 0px;
margin-top: 0px;
}

.registerbg {
width:99,9%;
background-image: url("back4.jpg");
padding: 0%;
margin: 0%;
}

.row {
font-size: 20px;
width: 30%;
margin-left:35%;
border-radius:10px;
color: MediumSlateBlue;
text-align: center;
background-color: mintcream;
margin-top: 0%;
}

.regrow {
font-size: 20px;
width: 30%;
color: MediumSlateBlue;
text-align: center;
background-color: mintcream;
margin-left:35%;
border-radius:20px;
padding-bottom:9%;

}


.button {
border: none;
color: white;
padding: 9px;
text-align: center;
text-decoration: none;
display: inline-block;
font-size: 20px;
background-color: MediumPurple;
border-radius: 5px;

}


.button:hover {
background-color: firebrick;
cursor: pointer;

}

.button:active {
background-color: brown;
box-shadow: 0 5px #666;
transform: translateY(4px);
}




.background h1{
text-align: center;
}
.row3 {
padding-top: 1%;
padding-bottom: 1%;
padding-left: 1%;
padding-right: 1%;
font-size: 10%;
width:100%;
background-color: rgb(243, 214, 171);
color: black;
display: flex;

border-radius: 8px;

}


</style>
              <div class="header ">
     <div class="rows " >
    <div class="footer ">
        	<img class="logo" src="https://i.ibb.co/VDngS9Z/logo.png "/>
    
       <a href="home">Home </a>

 	 		<a href="account.jsp " >Account </a>
 	

            <a href="viewMovies ">Available Movies </a>
    

            <a href="viewRatings " > Rate us! </a>
            
            <a href="viewInfo" > Info </a>
            
         
            
            <a href="logout"> Logout</a>
            
       </div>
    </div>
    </div>
 
   
            <br>

                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center" style="color:mediumslateblue;">Ratings</h3>
                    <hr>
                   
                    <div class="container text-left">

                        <a href="newRating" class="btn btn-success">Rate us!</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>User</th>
                                <th>Comment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="rating" items="${listRate}">

                                <tr>
                                   
                                    <td>
                                        <c:out value="${rating.username}" />
                                    </td>
                                    <td>
                                        <c:out value="${rating.comments}" />
                                    </td>
                                 
                                    
                                </tr>
                            </c:forEach>
                           
                        </tbody>

                    </table>
                </div>
            
        </body>

        </html>