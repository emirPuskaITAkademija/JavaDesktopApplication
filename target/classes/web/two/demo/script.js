var todos = [];

var todoWrapper = document.querySelector('.list-group');

function addTodo() {
    var newTodo = document.getElementById('todo').value;
}

function renderTodos() {
  var todoItem = `<li class="list-group-item d-flex align-items-center justify-content-between">
    <div class="form-check">
       <input class="form-check-input" type="checkbox">
       <label class="form-check-label">First todo</label>
    </div>
    <div>
       <button class="btn btn-primary">Edit</button>
       <button class="btn btn-danger">Delete</button>
    </div>
    </li>`
}

function deleteTodo() { }

function editTodo() { }