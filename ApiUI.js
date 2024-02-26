const fetch = require("node-fetch");

// Function to generate text using OpenAI API
async function generateText(prompt) {
    const apiKey = "25092cc469msh3cfd3ba967ac527p198060jsn84f661706744";
    const endpoint = "https://api.openai.com/v1/completions";
    const headers = {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${apiKey}`
    };
    const data = {
        "prompt": prompt,
        "max_tokens": 50,
        "temperature": 0.7
    };
    
    try {
        const response = await fetch(endpoint, {
            method: 'POST',
            headers: headers,
            body: JSON.stringify(data)
        });
        const result = await response.json();
        return result.choices[0].text;
    } catch (error) {
        console.error("Error generating text:", error);
        return null;
    }
}

// Function to fetch data from Community Transit Feeds API
async function fetchTransitData() {
    const url = 'https://community-transitfeeds.p.rapidapi.com/getFeedVersions?key=%3CREQUIRED%3E&feed=sfmta%2F60';
    const options = {
        method: 'GET',
        headers: {
            'X-RapidAPI-Key': '7c52e6a2b7msh38ebbe58afcb5f6p1406bcjsn930e37c7754c',
            'X-RapidAPI-Host': 'community-transitfeeds.p.rapidapi.com'
        }
    };

    try {
        const response = await fetch(url, options);
        const result = await response.text();
        return result;
    } catch (error) {
        console.error("Error fetching transit data:", error);
        return null;
    }
}

// Main function to coordinate API calls
async function main() {
    // Fetch transit data
    const transitData = await fetchTransitData();
    if (!transitData) {
        console.error("Failed to fetch transit data");
        return;
    }

    // Generate text based on transit data
    const prompt = `Bus transit information: ${transitData}. Once upon a time`;
    const generatedText = await generateText(prompt);
    console.log("Generated text:", generatedText);
}

// Call the main function to start the process
main();
