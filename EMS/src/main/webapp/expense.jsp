<%@page import="com.project.EMS.service.BussinessLogic, java.util.List" %>
<%@page import="com.project.EMS.model.User, com.project.EMS.model.Expense" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        margin: 20px;
        position: relative;
    }
    .logout {
        position: absolute;
        top: 10px;
        right: 20px;
        text-decoration: none;
        background: #dc3545;
        color: white;
        padding: 8px 15px;
        border-radius: 5px;
    }
    .logout:hover {
        background: #c82333;
    }
    .sort-container {
        position: absolute;
        top: 50px;
        right: 20px;
    }
    .sort-dropdown {
        display: none;
        position: absolute;
        background: white;
        border: 1px solid #ccc;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
        padding: 5px;
    }
    .sort-dropdown button {
        display: block;
        width: 100%;
        background: none;
        border: none;
        padding: 5px;
        cursor: pointer;
    }
    .sort-dropdown button:hover {
        background: #f4f4f4;
    }
    h2 {
        color: #333;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background: white;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: center;
    }
    th {
        background: #007BFF;
        color: white;
    }
    tr:nth-child(even) {
        background: #f2f2f2;
    }
    .total-section {
        font-size: 18px;
        font-weight: bold;
        margin-top: 10px;
    }
    button, input[type="submit"], input[type="reset"] {
        background: #007BFF;
        color: white;
        padding: 10px;
        border: none;
        cursor: pointer;
        margin: 5px;
        border-radius: 5px;
    }
    button:hover, input[type="submit"]:hover, input[type="reset"]:hover {
        background: #0056b3;
    }
    #expenseForm {
        display: none;
        width: 50%;
        margin: 20px auto;
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    input[type="text"], input[type="date"] {
        width: 80%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
</style>
<script>
function toggleForm() {
    var form = document.getElementById("expenseForm");
    var toggleBtn = document.getElementById("toggleBtn");
    
    if (form.style.display === "none") {
        form.style.display = "block";
        toggleBtn.innerText = "Hide Form";
    } else {
        form.style.display = "none";
        toggleBtn.innerText = "Add Expense";
    }
}

function toggleSortOptions() {
    var dropdown = document.getElementById("sortDropdown");
    dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
}

function sortTable(index, isNumeric) {
    var table = document.getElementById("expensetable");
    var rows = Array.from(table.rows).slice(1);
    rows.sort((rowA, rowB) => {
        var cellA = rowA.cells[index].innerText.trim();
        var cellB = rowB.cells[index].innerText.trim();
        return isNumeric ? (parseFloat(cellA) - parseFloat(cellB)) : (new Date(cellA) - new Date(cellB));
    });
    rows.forEach(row => table.appendChild(row));
}
</script>
</head>
<body>
<a href="logout" class="logout">Logout</a>


<h2>Welcome, <%=session.getAttribute("Uname") %></h2>

<h2>Expense List</h2>
<table id="expensetable">
<thead>
<tr>

<th>Date</th>
<th>Type</th>
<th>Description</th>
<th>Amount</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<%
BussinessLogic logic = new BussinessLogic();
String uname = session.getAttribute("Uname").toString();
User user = new User(uname);
List<Expense> expenses = null;
double sum = 0;
try {
    expenses = logic.DISPLAYexpense(user);
} catch (Exception e) {
    e.printStackTrace();
}
if (expenses != null) {
    for (Expense expense : expenses) {
        sum += expense.getAmount();
%>
<tr>
    
    <td><%= expense.getDate() %></td>
    <td><%= expense.getType() %></td>
    <td><%= expense.getDescription() %></td>
    <td><%= expense.getAmount() %></td>
    <td>
        <form action="delete" method="post">
            <input type="hidden" name="expenseId" value="<%= expense.getExpenseid() %>">
            <input type="submit" value="Delete">
        </form>
    </td>
</tr>
<%
    }
}
%>
</tbody>
</table>
<div class="total-section">
<% out.println("Total: "+ sum); %>
</div>

<!-- Toggle Button -->
<button id="toggleBtn" onclick="toggleForm()">Add Expense</button>

<!-- Add Expense Form -->
<div id="expenseForm">
<form action="addexpense" method="post">
<label for="date">Date :</label>
<input type="date" id="date" name="date" required="required"><br>

<label for="type">Type :</label>
<input type="text" id="type" name="type" required="required"><br>

<label for="description">Description :</label>
<input type="text" id="description" name="description" required="required"><br>

<label for="amount">Amount :</label>
<input type="text" id="amount" name="amount" required="required"><br>

<input type="submit" value="Add Expense">
<input type="reset" value="Reset">
</form>
</div>

</body>
</html>
