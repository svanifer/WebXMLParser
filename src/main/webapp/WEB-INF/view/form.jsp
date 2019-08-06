<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="../fragments/header.jsp" />
<body>
    <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/main"  enctype="multipart/form-data">
            <label class="radio-inline"><input type="radio" name="radios" value="dom" checked>DOM-parser : </label>
            <label class="radio-inline"><input type="radio" name="radios" value="sax">SAX-parser : </label>
            <label class="radio-inline"><input type="radio" name="radios" value="stax">StAX-parser : </label>
            <div class="form-group">
                <label for="exampleFormControlFile1">Choose file</label>
                <input type="file" class="form-control-file" name="file" id="exampleFormControlFile1" required>
            </div>
            <button type="submit" class="btn btn-primary">Check</button>
        </form>
    </div>
    <jsp:include page="../fragments/footer.jsp" />
</body>
</html>
