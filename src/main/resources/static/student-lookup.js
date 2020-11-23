const studentNumberInput = document.getElementById('studentNumberInputId')
const submitButton = document.getElementById('submit')
const resultsBoard = document.getElementById('results')

submitButton.addEventListener('click', async () => {
    const studentNumber = studentNumberInput.value
    displayResults(JSON.stringify(await getStudent(studentNumber)))
})

function displayResults(results) {
    resultsBoard.innerText = ""
    resultsBoard.innerText = results
}