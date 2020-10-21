const http = require('http')

const host = '127.0.0.1'
const port = 3000

const server = http.createServer((request, response) => {
    response.writeHead(200, { "Content-Type": "application/json" })

    const json_response = {
        status: 200,
        message: 'successful',
        result: ['sunday', 'monday', 'tuesday', 'wednesday'],
        code: 200
    }

    console.log('Server running')
    response.end(JSON.stringify(json_response))
})

server.listen(port, host, (error) => {
    if (error) {
        return console.log('Error occured: ', error)
    }

    console.log('server is listening on ' + host + ':' + port)
})