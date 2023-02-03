import React, {useState, useRef, useEffect} from 'react';
import TodoList from './TodoList';
import uuid from 'react-uuid'

const LOCAL_STORAGE_KEY = 'DropDee.todos'
function App() {
    const [todos, setTodos] = useState([])
    const todoNameRef = useRef()

    useEffect(() => {
        const storedTodos = JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY))
        if(storedTodos) setTodos(storedTodos)
    }, [])

    useEffect(() => {
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(todos))
    },[todos])


    function handleAddTodo(e)
    {
        const name = todoNameRef.current.value
        if(name === '') return
        setTodos(prevTodos => {
            return [...prevTodos, {id: uuid(), name: name, complete: false}]
        })

    }
  return (
      <>
      <TodoList todos = {todos}/>
          <input ref = {todoNameRef} type = "text"/>
          <button onClick={handleAddTodo}> Add Todo</button>
          <button> Clear Completed Todos</button>
          <div> 0 left Todo</div>
      </>
  )
}


export default App;
