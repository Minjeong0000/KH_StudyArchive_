function del(detailNo){

  $.ajax({
    url: "http://127.0.0.1:8080/todo" , 
    method: "delete" , 
    data: {
      num : detailNo
    } ,
    success: function(x){
      console.log("del result : " , x);
    },
  });
}