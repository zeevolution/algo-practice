// -- Problem's Formulation
// Create an "eventing" library out of the
// Event class. The Events class should
// have methods 'on', 'trigger', and 'off'

class Event {
  constructor() {
    this.events = {};
  }
  // Register an event handler
  on(eventName, callback) {
    if (this.events[eventName]) {
      this.events[eventName].push(callback);
    } else {
      this.events[eventName] = [callback];
    }
  }

  // Trigger all callbacks associated
  // with a given eventName
  trigger(eventName) {
    if (this.events[eventName]) {
      for (let callback of this.events[eventName]) {
        callback();
      }
    }
  }

  //Remove all event handlers associated
  off(eventName) {
    if (this.events[eventName]) {
      delete this.events[eventName];
    }
  }
}

module.exports = Event;
