console.log("I am script! Hello!")
window.addEventListener('DOMContentLoaded', function () {
  main()
})

function main() {
  const rootDiv = document.getElementById('root')
  let appComponent = new App()
  draw(rootDiv, appComponent)
}

function draw(container, component) {
  let fRender = component.render()
  fRender(container)
}

class Component {
  props = {}
  state = {}

  constructor(props) {
    this.props = props
  }

  render() {
    return (parent) => {
      let newDiv = document.createElement("div")
      newDiv.append(document.createTextNode("Method was invoked from root class \"Component\", you need to implement method render() in subclasses."))
      parent.append(newDiv)
    }
  }
}

class App extends Component {

  constructor(props) {
    super(props)
    this.state = {
      nameValue: ""
    }
    this.handleChange = this.handleChange.bind(this)
    this.onClickButton = this.onClickButton.bind(this)
  }

  onClickButton() {
    alert(this.state.nameValue)
  }

  handleChange(event) {
    console.log(this.state)
    this.state.nameValue = event.target.value
    console.log(this.state)
  }

  render() {
    return (parent) => {
      let div = document.createElement('div')
      let textField = new TextField({label: "Name", placeholder: "Ivan", onChange: this.handleChange, className: "name-text-field"})
      let fRender = textField.render()
      parent.append(div)
      fRender(div)
      let button = new Button({onClick: this.onClickButton, caption: "Push Me!"})
      fRender = button.render()
      fRender(div)

      let textField2 = new TextField({label: "Last Name", placeholder: "Ivanov"})
      fRender = textField2.render()
      fRender(div)

    }
  }
}



// Base Components
class TextField extends Component {
  constructor(props) {
    super(props)
    this.state = {}
  }

  render() {
    return (parent) => {
      console.log(this.state)
      let div = document.createElement('div')
      let label = document.createElement('label')
      label.className = this.props.className
      let input = document.createElement('input')
      label.append(document.createTextNode(this.props.label))
      label.append(input)
      input.placeholder = this.props.placeholder
      input.onchange = this.props.onChange
      div.append(label)
      parent.append(div)
    }
  }
}

class Button extends Component {
  constructor(props) {
    super(props)
    this.state = {}
  }

  render() {
    return (parent) => {
      let div = document.createElement('div')
      let button = document.createElement('button')
      button.append(document.createTextNode(this.props.caption))
      button.onclick = this.props.onClick
      div.append(button)
      parent.append(div)
    }
  }
}