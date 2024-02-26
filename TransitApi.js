const protobuf = require('protobufjs');
const fetch = require('node-fetch'); // if running in Node.js

const url = 'https://cttprdtmgtfs.ctttrpcloud.com/TMGTFSRealTimeWebService/TripUpdate/TripUpdates.pb';
const options = {
    method: 'GET',
};

try {
    const response = await fetch(url, options);
    const buffer = await response.arrayBuffer();
    const root = await protobuf.load("path_to_proto_file.proto"); // Load your Protocol Buffers definition
    const Message = root.lookupType("YourMessageType"); // Replace YourMessageType with your actual message type
    const message = Message.decode(new Uint8Array(buffer));
    console.log(message);
} catch (error) {
    console.error(error);
}
//https://maps.googleapis.com/maps/api/js?key=AIzaSyAgH9DaJY5lJK9APPxs8A89RZPP8STX2N4&callback=initMap