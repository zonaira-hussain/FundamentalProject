'use strict';

let readAllbtn = document.querySelector('#allBtn');
let readByIdbtn = document.querySelector('.readByIdBtn');
let readAllTable = document.querySelector('.readAllTable');
let readByGenreBtn = document.querySelector('.readByGenreBtn');
let readByTitleBtn = document.querySelector('.readByTitleBtn');
let delBtn = document.querySelector('.delBtn');
let updateBtn = document.querySelector('.updateBtn');
let title1 = document.querySelector('#title');
let genre1 = document.querySelector('#genre');
let rating1 = document.querySelector('#rating');
let summary1 = document.querySelector('#summary');
let createbtn = document.querySelector('.createBtn');
let targetDiv = document.querySelector('#targetDiv');
let titleSearch = document.querySelector('#titleSearch');
let genreSearch = document.querySelector('#genreSearch');
let idSearch = document.querySelector('#idSearch');
let reviewIdForDel = document.querySelector('#reviewIdForDel');
let updateId = document.querySelector('#updateId');
let updatedTitle = document.querySelector('#updatedTitle');
let updatedGenre = document.querySelector('#updatedGenre');
let updatedRating = document.querySelector('#updatedRating');
let updatedSummary = document.querySelector('#updatedSummary');


let readAllReviews = function(data){
        let newReviewId = document.createElement('td');
        let newTitle = document.createElement('td');
        let newGenre = document.createElement('td');
        let newRating = document.createElement('td');
        let newSummary = document.createElement('td');
        let reviewIdData = data.reviewID;
        let titleData = data.title;
        let genreData = data.genre;
        let ratingData = data.rating;
        let summaryData = data.summary;
        newReviewId.innerHTML=reviewIdData;
        newTitle.innerHTML=titleData;
        newGenre.innerHTML=genreData;
        newRating.innerHTML=ratingData;
        newSummary.innerHTML=summaryData;
        readAllTable.appendChild(newReviewId);
        readAllTable.appendChild(newTitle);
        readAllTable.appendChild(newGenre);
        readAllTable.appendChild(newRating);
        readAllTable.appendChild(newSummary);
    }



let readAllFn = function(){
fetch(`http://localhost:9090/reviews/readAll`)
    .then((response) =>{
        if (response.status !== 200){
            console.log(`status: ${response.status}`);
            return;
        }
        response.json()
        .then((data)=>{
            for(let i of data){
                readAllReviews(i);
            }
        })
        .catch((error) => console.log(`${error}`))
    })
}
    
readAllbtn.addEventListener('click', readAllFn);

let id = idSearch.value;
let readById = function(){
fetch(`http://localhost:9090/reviews/read/byId/${id}`)
.then((response) => {
    if (response.status !== 200) {
        console.log(`Status ${response.status}`);
        return;
    }
    response.json()
    .then((data)=>{
        for(let i of data){
            readAllReviews(i);
        }
    })
    .catch((error) => console.log(`Error ${error}`));
})
} 
readByIdbtn.addEventListener('click',(event) => {
    event.preventDefault();
    readById();

});

let readByGenreFn = function(){
    fetch(`http://localhost:9090/reviews/read/byGenre/${genreSearch}`)
    .then((response) => {
        if (response.status !== 200) {
            console.log(`Status ${response.status}`);
            return;
        }
        response.json()
        .then((data)=>{
            for(let i of data){
                readAllReviews(i);
            }
        })
        .catch((error) => console.log(`Error ${error}`));
    }) 
}
readByGenreBtn.addEventListener('click', readByGenreFn);

let readByTitleFn = function(){
    fetch(`http://localhost:9090/reviews/read/byTitle/${titleSearch}`)
    .then((response) => {
        if (response.status !== 200) {
            console.log(`Status ${response.status}`);
            return;
        }
        response.json()
        .then((data)=>{
            for(let i of data){
                readAllReviews(i);
            }
        })
        .catch((error) => console.log(`Error ${error}`));
    }) 
}
readByTitleBtn.addEventListener('click',readByTitleFn);

// const newReview = {
//     title:document.getElementById('title').value,
//     genre:document.getElementById('genre').value,
//     rating:document.getElementById('rating').value,
//     summary:document.getElementById('summary').value
// }

let newReview = {
    "title":title1,
    "genre":genre1,
    "rating":rating1,
    "summary":summary1
};

let PostReview = function() {
    let newTitle = document.createElement('a');
    let newGenre = document.createElement('a');
    let newRating = document.createElement('a');
    let newSummary = document.createElement('a');

    newTitle.textContent=title1.value;
    newGenre.textContent=genre1.value;
    newRating.textContent=rating1.value;
    newSummary.textContent=summary1.value;
    
    targetDiv.appendChild(newTitle);
    targetDiv.appendChild(newGenre);
    targetDiv.appendChild(newRating);
    targetDiv.appendChild(newSummary);
}

let createNewReview = function() {

    fetch(`http://localhost:9090/reviews/create`,{
        method: `POST`,
        headers: {
            "Content-type":"application/json"
        },
        body: JSON.stringify(newReview)
    })
    .then((response)=>{
        if (response.status !== 201) {
            console.log(`Status ${response.status}`);
            return;
        } else {
            console.log(`All good! ${response.status}`);
        }response.json()
    .then((data)=> console.log(`Request succesful with JSON response ${data}`))
    .catch((error)=>console.log(error))
    });
    
}
    
    createbtn.addEventListener('click',  (event) => {
        event.preventDefault();
        createNewReview();
        PostReview();
    });

let delId = reviewIdForDel.value;
let deleteFunction = function(){
    fetch(`http://localhost:9090/reviews/delete/${delId}`,{
        method:`DELETE`
    })
    .then((data) => console.log(`Review with this id: ${data}`))
    .catch((error) => console.log(error));
}
delBtn.addEventListener('click', deleteFunction);

let updatedReview = {
    "reviewID":updateId,
    "title":updatedTitle,
    "genre":updatedGenre,
    "rating":updatedRating,
    "summary":updatedSummary
};

function updateFunction(){

    fetch(`http://localhost:9090/reviews/${updateId}`, {
      method: 'PUT',
      headers: { "Content-Type": "application/json; charset=utf-8" },
      body: JSON.stringify(updatedReview)
    })
    .then( (response) => {
        if (response.status !== 201) {
            console.log(`Status ${response.status}`);
            return;
        } else {
            console.log(`All good! ${response.status}`);
        }
        response.json()
    .then( (data) => console.log(`Update succesful ${data}`))
    .catch( (error) => console.log(error))
    });
}
updateBtn.addEventListener('click',updateFunction);

    
