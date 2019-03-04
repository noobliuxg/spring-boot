
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>显示用户数据</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
		<#list list as user >
			<tr>
                <th>${user.id }</th>
                <th>${user.name }</th>
                <th>${user.age }</th>
            </tr>
        </#list>
</table>
</body>
</html>