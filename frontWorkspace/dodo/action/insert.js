function insertTodo(){

  const str = document.querySelector("input[name=content]").value;
  document.querySelector("input[name=content]").value = "";

  $.ajax( {
    url: "http://127.0.0.1:8080/todo",
    method: "POST",
    data: {
      content: str
    },
    success: function(x){
      console.log( x );
      loadTodo();
    },
  } );

}