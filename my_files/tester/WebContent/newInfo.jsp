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
background-image: url("back4.png");
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

<title>Local Cinema</title>
</head>
<body>
    <div class="header ">
     <div class="rows " >
    <div class="footer ">
        	<img class="logo" src="https://i.ibb.co/VDngS9Z/logo.png  "/>
    
        <a href="home">Home </a>

 		

            <a href="editMovies">Edit Movies </a>
    

            <a href="viewRating" >View Ratings </a>
            
            <a href="editInfo" >Edit Info </a>
            
            
            <a href="logout" >logout </a>
            
       </div>
    </div>
    
</div>
 
 
   
 
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       
                        <c:if test="${info == null}">
                            <form action="newInfo" method="get">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${info != null}">
                                    Edit Info
                                </c:if>
                                <c:if test="${info == null}">
                                    Add New Info
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${info != null}">
                            <input type="hidden" name="id" value="<c:out value='${info.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Info Title</label> <input type="text" value="<c:out value='${info.title}' />" class="form-control" name="title" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label> Description</label> <input type="text" value="<c:out value='${info.descr}' />" class="form-control" name="descr">
                        </fieldset>

                       
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                        
                    </div>
                </div>
            </div>
            
        </body>

        </html>