import fetch from "unfetch"

//Überprüft auch ob statuscoe 200 übermittelt wurde erst dann werden die Daten übermittelt
const checkStatus = response => {

    if (response.ok) {
        return response
    }
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}
export const getAllStudents = () =>
    //get request an srudentcontroller
    fetch("api/v1/students").then(checkStatus);//request durchläuft nun einen proxy der die adresse über den port unser spring boot application mappt CORS


export const addNewStudent = student =>
    fetch("api/v1/students",{
        headers:{
            'Content-Type':'application/json'
        },
        method:'POST',
        body:JSON.stringify(student)

    }).then(checkStatus)

export const deleteStudent = studentId =>
    fetch(`api/v1/students/${studentId}`, {
        method: 'DELETE'
    }).then(checkStatus);




