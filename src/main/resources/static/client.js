const rootUrl = 'http://localhost:8081'

async function getStudent(admissionNumber) {
    try {
        const response = await fetch(`${rootUrl}/student/${admissionNumber}`)
        return await response.json()
    } catch (err) {
        throw 'Request failed'
    }
}

async function registerStudent(student) {
    const response = await fetch(
        `${rootUrl}/student`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(student)
        })

    return await response.json()
}