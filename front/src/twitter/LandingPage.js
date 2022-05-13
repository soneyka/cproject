import React from 'react'
import { Button, Container, CssBaseline, Divider, Typography } from '@material-ui/core'

function LandingPage() {
    return (
        <div className="landingPage">
            <CssBaseline/>
            <Container fixed>
                <Typography component="div" style={{ backgroundColor : '#E9ECEF', height: '40vh', borderRadius: '20px'}}>
                    <br></br>
                    <Typography variant="h3" gutterBottom style={{textAlign: 'center'}}>
                        Добро пожаловать!
                    </Typography>
                    <br></br>
                    <Typography variant="h4" gutterBottom style={{paddingLeft: '10px'}}>
                        Нажми на нижние кнопки
                    </Typography>
                    <Divider/>
                    <Button variant="contained" color="primary" href="/twitter/register" style={{marginTop: '30px', marginLeft: '10px'}}>
                        Зарегистироваться
                    </Button>
                    <Button variant="contained" color="primary" href="/twitter/login" style={{marginTop: '30px', marginLeft: '10px'}}>
                        Войти
                    </Button>
                </Typography>
            </Container>
        </div>
    )
}

export default LandingPage
