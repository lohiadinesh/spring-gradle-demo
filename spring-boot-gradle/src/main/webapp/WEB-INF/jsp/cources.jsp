

<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/courses" var="courses" />
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.contextPath}" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.button {
	padding: 5px 15px;
	font-size: 19px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: #4CAF50;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
}

.button:hover {
	background-color: #3e8e41
}

.button:active {
	background-color: #3e8e41;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}
</style>

<script>
	$(document).ready(function() {
		loadCourses();
	});
	
	function loadCourses(){
		Utils.ajaxCall('GET', "${baseURL}/courses", '', loadData, '', false);
	}
	
	function loadData(data) {

		// EXTRACT VALUE FOR HTML HEADER. 
		var col = [];
		for (var i = 0; i < data.length; i++) {
			for ( var key in data[i]) {
				if (col.indexOf(key.toUpperCase()) === -1) {
					col.push(key.toUpperCase());
				}
			}
		}

		// CREATE DYNAMIC TABLE.
		var table = document.createElement("table");

		// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

		var tr = table.insertRow(-1); // TABLE ROW.

		var th = document.createElement("th"); // TABLE HEADER.
		tr.appendChild(th);
		for (var i = 0; i < col.length; i++) {
			var th = document.createElement("th"); // TABLE HEADER.
			th.innerHTML = col[i];
			tr.appendChild(th);
		}

		// ADD JSON DATA TO THE TABLE AS ROWS.
		for (var i = 0; i < data.length; i++) {

			tr = table.insertRow(-1);

			var tabCell = tr.insertCell(-1);
			tabCell.innerHTML = "<input id='"+data[i][col[0].toLowerCase()]+"' type='checkbox' class='checkbox'></input>";
			for (var j = 0; j < col.length; j++) {
				var tabCell = tr.insertCell(-1);
				tabCell.innerHTML = data[i][col[j].toLowerCase()];
			}
		}

		// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
		var divContainer = document.getElementById('container');
		divContainer.innerHTML = "";
		divContainer.appendChild(table);
		onClick();
	}
	
	var list = [];
	function onClick(){
		$('input[type="checkbox"]').click(function(){
			var checked = $(this).prop("checked");
			var objReport = new Object();
			objReport.id = this.id;
			if (checked){
				list.push(objReport);
			} 
			else{
				$.each(list, function(i){
				    if(list[i].id ==  objReport.id) {
				    	list.splice(i,1);
				        return false;
				    }
				});
			}
		});	
	}
	
	function Utils() {
	}
	
	Utils.isValid = function(element) {
		if (element != null && element != undefined && element != ''
				&& element != 'null') {
			return true;
		}
		return false;
	}
	
	// paramDataWithResponse is the data which needs to be passed additional to response.
	Utils.ajaxCall = function(type, url, data, callback, successMsg,
			showSuccessMsg, paramDataWithResponse) {
		$.ajax({
			type : type,
			contentType : 'application/json',
			url : url,
			data : data,
			beforeSend : function() {
			},
			complete : function() {
			},
			success : function(data) {
				if (Utils.isValid(callback))
					callback(data, paramDataWithResponse);
			},
			error : function(e) {
			},
			failure : function(record) {
			}
		});
	};
	function deleteRecord(){
		Utils.ajaxCall('DELETE', "${baseURL}/courses", JSON.stringify(list), deleteResponse, '', false);
	}
	function deleteResponse(data){
		alert(data);
		loadCourses();
	}

</script>
</head>
<body>
	<div id="container"></div>
	<div style="margin-top: 10px;">
		<button class="button">Save</button>
		<button class="button">Update</button>
		<button class="button" onclick="deleteRecord()">Delete</button>
	</div>

</body>


</html>
