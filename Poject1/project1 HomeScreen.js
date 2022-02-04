const url = "http://localhost:3000/"



async function users(){
    let response = fetch (url + "user")

 
   console.log(response);
if(response.status === 200) {

    let data = await reposnse.jason();
console.log(data);

for (let user of data){
    let row=document.createElement("tr");

    let cell = document.createElement("td")

    cell.innerHTML = user.user_id;

    row.appendChild(cell);

    //we'll do this^ for every column in employees

    let cell2 = document.createElement("td");
    cell2.innerHTML = user.ers_username;
    row.appendChild(cell2);

    let cell3 = document.createElement("td");
    cell3.innerHTML = user.ers_password;
    row.appendChild(cell3);

    let cell4 = document.createElement("td");
    cell4.innerHTML = user.user_f_name;
    row.appendChild(cell4);

    let cell5 = document.createElement("td");
    cell5.innerHTML = user.user_l_name;
    row.appendChild(cell5);

    let cell6 = document.createElement("td");
    cell6.innerHTML = user.email;
    row.appendChild(cell6);

    document.getElementById("user").appendChild(row);
}




}


}

//this function will send the user-inputted login credentials to our server
async function loginFunction() {

    //gather the user inputs from the login inputs
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let user = {
        username:usern,
        password:userp
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    console.log(user)


    let response = await fetch (url + "login", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(user), //turn our user object into JSON
        credentials: "include"

    });

    console.log(response.status); //userful for debug :)

    //control flow based on successful/unsuccessful login
    if(response.status === 202) {
        //wipe our login row and welcome the user 
        document.getUserById("loginRow").innerText="Welcome!";
    } else {
        document.getUserById("loginRow").innerText="Login failed! Refresh the page";
    }


}
