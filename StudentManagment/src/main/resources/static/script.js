document.addEventListener("DOMContentLoaded", () => {
  const backbuttonall = document.getElementsByClassName("backbutton");
  const showall = document.getElementById("show_all");
  const addstd = document.getElementById("add");
  const update = document.getElementById("update");
  const remove = document.getElementById("remove");
  const updateredirect1 = document.getElementById("updateredirect");
  const backbutton1 = document.getElementById("backbutton12");
  const success_message = document.getElementById("success_message");
  const remove_sucess = document.getElementById("remove_sucess");
  const add_Student_submit = document.getElementById("add_Student_submit");


  Array.from(backbuttonall).forEach((btn) => {
    btn.addEventListener("click", () => {
      window.location.replace("/");
    });
  });

  if (showall) {
    showall.addEventListener("click", () => {
      window.location.replace("Allstudents");
    });
  }

  if (addstd) {
    addstd.addEventListener("click", () => {
      window.location.replace("addstudent");
    });
  }

  if (update) {
    update.addEventListener("click", () => {
      window.location.replace("update_student");
    });
  }

  if (remove) {
    remove.addEventListener("click", () => {
      window.location.replace("removeStudent");
    });
  }

  if (updateredirect1) {
    updateredirect1.addEventListener("click", () => {
      window.location.replace("update_student2");
    });
  }

  if (backbutton1) {
    backbutton1.addEventListener("click", () => {
      window.location.replace("update_student");
    });
  }

if (success_message) {
  success_message.addEventListener("click", () => {
      alert("successfully updated")
    });
  }

  if (remove_sucess) {
    remove_sucess.addEventListener("click", () => {
      alert("successfully removed student from database")
    });
  }

  if (add_Student_submit) {
    add_Student_submit.addEventListener("click", () => {
      alert("success student added to database")
    });
  }
  


  


});
