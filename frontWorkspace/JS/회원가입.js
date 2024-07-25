const pwdTag = document.querySelector("input[type=password]");
pwdTag.addEventListener("click" , function(){
  const pwdText = document.querySelector("#pwdText");
  pwdText.classList.add("active");
} );

pwdTag.addEventListener("blur" , function(){
  const pwdText = document.querySelector("#pwdText");
  pwdText.classList.remove("active");
});


const pwdCheckTag = document.querySelector("input[name=pwdCheck]");
pwdCheckTag.addEventListener("focus" , function(){
  const pwdCheckText = document.querySelector("#pwdCheckText");
  pwdCheckText.classList.add("active");
});

