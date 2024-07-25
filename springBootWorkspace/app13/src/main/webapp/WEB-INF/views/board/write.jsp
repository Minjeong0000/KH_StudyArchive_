<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>

</head>
<body>

    <h1>S3 파일 업로드 테스트</h1>

    <form action="/board/write" method="post" enctype="multipart/form-data">
        <input type="file" name="f">
        <br />
        <input type="submit" value="제출하기">
    </form>

</body>
</html>