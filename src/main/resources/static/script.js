const API_URL = "http://localhost:8080/api/movies";

document.addEventListener("DOMContentLoaded", () => {
    fetchMovies();
    document.getElementById("movieForm").addEventListener("submit", addMovie);
})

//fetch and display movies
async function fetchMovies() {
    try {
        const response = await fetch(API_URL);
        const movies = await response.json();
        const movieList = document.getElementById("movieList");
        movieList.innerHTML = "";

        if (movies.length === 0) {
            movieList.innerHTML = "<p>No movies found. Add One!</p>";
            return;
        }

        movies.forEach(movie => {
            const card = document.createElement("div");
            card.className = "movie-card";
            card.innerHTML =
                <div>
                    <h3>${movie.title}</h3>
                    <p><strong>Genre:</strong>${movie.genre}</p>
                    <p><strong>Duration:</strong>${movie.durationMinutes} mins</p>
                </div>
            <button class="btn-delete" onclick="deleteMovie(${movie.id})">Delete</button>;
            movieList.appendChild(card);

        });


    } catch (error) {
        console.log("Error fetching movies:", error);
    }
}

async function addMovie(event){
    event.preventDefault();
    const errorMsg = document.getElementByid("errorMessage");
    errorMsg.classList.add("hidden");

    const newMovie = {
        title: document.getElementById("title").value,
        genre: document.getElementById("genre").value,
        durationMinutes: parseInt(document.getElementById("duration").value),
    };

    try{
        const response = await fetch(API_URL,{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(newMovie)
        });
        if (!response.ok) {
            const errors = await response.json();
            throw new Error(Object.values(errors).join(", "));
        }

        document.getElementById("movieForm").reset();
        fetchMovies(); // Refresh the list
    } catch (error) {
        errorMsg.textContent = error.message;
        errorMsg.classList.remove("hidden");
    }

}
async function deleteMovie(id) {
    if (!confirm("Are you sure you want to delete this movie?")) return;

    try {
        const response = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        if (response.ok) {
            fetchMovies(); // Refresh list
        } else {
            alert("Error deleting movie.");
        }
    } catch (error) {
        console.error("Error deleting:", error);
    }
}