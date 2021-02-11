import flask
from flask import request, jsonify

app = flask.Flask(__name__)
app.config["DEBUG"] = True

# Create some test data for our catalog in the form of a list of dictionaries.
response = {
    "app": "Python",
    "message": "I 💕 Python3!!!"
}


# A route to return all of the available entries in our catalog.
@app.route('/v1/whoami', methods=['GET'])
def api_all():
    return jsonify(response)

print("Starting Python App port 3030")
app.run(host='0.0.0.0', port=3030)
