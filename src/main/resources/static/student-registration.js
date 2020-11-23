const form = document.getElementsByTagName('form')[0]
const resultsBoard = document.getElementById('results')

form.addEventListener('submit', async function (e) {
    e.preventDefault()

    try {
        const admissionNumber = await registerStudent({
            id: null,
            name: this.name.value,
            email: this.email.value,
            phoneNumber: this.phoneNumber.value,
            address: this.address.value,
            entryPoints: this.entryPoints.value
        })

        resultsBoard.innerText = admissionNumber
    } catch (e) {
        console.error(e)
    }
})