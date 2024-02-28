<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CurrencyConverter</title>
    <style> 
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        } 
        body{
            display: flex;
            align-items: center;
            justify-content:center;
            background: rgb(0,0,0);
			background: linear-gradient(102deg, rgba(0,0,0,1) 0%, rgba(180,45,15,1) 79%, rgba(0,0,0,1) 92%);
            width: 100%;
            height: 100vh;
        }  
        .converterBox{
            width: 25%;
            height: 300px;
            border: 0;
            border-radius: 10px;
            background : rgba(0,0,0,0.3);
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
        .converterBox input{
            width: 90%;
            height: 50px;
            padding: 10px;
            border: 0;
            border-radius: 10px;
            background: rgba(0, 0, 0, 0.7);
            color: white;
            font-size: 20px;
        }
        .selecter{
            display: flex;
            margin-top: 20px;
            align-items: center;
            width: 80%;
            justify-content: space-around;
        }
        .selecter select{
            width: 25%;
            height: 30px;
            border: 0;
            color: white;
            background: rgba(0, 0, 0, 0.7);
            border-radius: 5px;
            padding: 5px;
        }
        .converterBox button{
            margin-top: 20px;
            background: rgba(0, 0, 0, 0.7);
            color: white;
            width: 70%;
            height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
            border: 0;
            border-radius: 10px;
            font-size: 15px;
            cursor : pointer;
        }
        .converterBox h2{
        	margin-top : 20px;
        	color : white;
        }
    </style>
</head>
<body>
	<div class="converterBox">
        <input type="text" name="amount" id="amount">
        <div class="selecter">
            <select name="from" id="from">
            </select>
            <select name="to" id="to">
            </select>
        </div>
        <h2>${converterRate}</h2>
        <button id="button" type="submit">CONVERTER</button>
    </div>
    <script src="codes.js"></script>
</body>
<script>
    const newSelect = document.querySelectorAll("select");
    for (let select of newSelect)
    {        
        for(code in countryList)
        {
            let newOption = document.createElement("option");
            newOption.innerText = code;
            newOption.value = code;
            if(select.name === "from" && code === "USD" ){
                newOption.selected = true;
            }
            else if(select.name === "to" && code === "INR"){
                newOption.selected = true;
            }
            select.append(newOption);
        }
    }
</script>
</html>