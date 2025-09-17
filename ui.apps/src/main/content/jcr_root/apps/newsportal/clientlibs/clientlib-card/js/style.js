document.addEventListener("DOMContentLoaded", () => {
    const container = document.getElementById("articles-container");

    if (!container) return;

    fetch("/bin/newsportal/articles")
        .then(response => {
          
            if (!response.ok) {
                throw new Error("Network response was not ok " + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            container.innerHTML = data.map(article => createCard(article)).join('');
        })
        .catch(error => {
            console.error("Error fetching articles:", error);
            container.innerHTML = "<p>Unable to load articles at this time.</p>";
        });

    function createCard(article) {
          console.log("article Response",article)
        return `
            <div class="article-card">
                <img src="${article.image}" alt="${article.title}" class="article-image"/>
                <h3 class="article-title">${article.title}</h3>
                <p class="article-description">${article.description}</p>
                <p class="article-price">$${article.price}</p>
            </div>
        
        `;
    }
});
