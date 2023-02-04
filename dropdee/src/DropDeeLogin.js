import React from 'react';

export default function DropDeeLogin()
{
    return(
        todos.map(todo => {
            return <Todo key={todo.id} toggleTodo={toggleTodo} todo = {todo}/>
        })
    )
}