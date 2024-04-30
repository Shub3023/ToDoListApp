<%@page import="com.jspiders.todolist.pojo.TaskList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>To-do List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f5f5f5;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
        .completed-button {
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>
    <h2>All Tasks</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Task</th>
                <th>Status</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<TaskList> taskLists = (List<TaskList>) request.getAttribute("tasks");
            if (taskLists != null && !taskLists.isEmpty()) {
                for (TaskList taskList : taskLists) {
            %>
            <tr>
                <td><%=taskList.getId()%></td>
                <td><%=taskList.getTask()%></td>
                <td><%=taskList.getStatus()%></td>
                <td>
                    <%
                    if (taskList.getStatus().equals("incompleted")) {
                    %>
                    <form action="updateTask/<%=taskList.getId()%>" method="post">
                        <button class="completed-button" type="submit">FINISH TASK</button>
                    </form>
                    <%
                    } else {
                    %>
                    <%
                    }
                    %>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4">No tasks found.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</body>
</html>
