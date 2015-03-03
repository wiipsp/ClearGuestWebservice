<html>
<head>
<script type="text/javascript" src="/Jersey/scripts/jquery-1.6.4.js"></script>
<script type="text/javascript">

  
  function aa(){
  alert(11);

	$.ajax({ 
          type: "get", 
          url: "/Jersey/rest/test/getUserById", 
          data: {id:"ESTESTDATA0000000000000000000057"},
          dataType: "json", 
          contentType:'application/json', 
          success: function (data) { 
          	alert(2);
                 alert(data.userId); 
          }, 
          error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    }
  });

}


</script>
</head>
<body>

<div id="myDiv"><h2>change content</h2></div>
<button id="b01" type="button" onClick="aa()">change</button>

</body>
</html>
