import { Button, Container, CssBaseline, Divider, Typography } from '@material-ui/core'
import React, {useEffect} from 'react'

function Logout() {

    useEffect(() => {
        localStorage.removeItem("userName")
    }, [])

    return (
        <div className="logout">
            <CssBaseline/>
            <Container fixed>
                <Typography component="div" style={{ backgroundColor : '#E9ECEF', height: '30vh', borderRadius: '20px'}}>
                    <Typography variant="h3" gutterBottom style={{ padding: '15px'}}>
                        Успешно вышли из аккаунта
                    </Typography>
                    <Divider/>
                    <Button variant="outlined" color="primary" href="/twitter/login" style={{marginTop: '30px', marginLeft: '10px'}}>
                        Войти в существующий аккаунт
                    </Button>
                </Typography>
            </Container>
        </div>
    )
}

export default Logout
