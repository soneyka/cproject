import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import {useForm, Controller} from 'react-hook-form'
import { useHistory } from "react-router";
import axios from 'axios';

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%',
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function Registration() {
  const classes = useStyles();
  const {register, handleSubmit, errors} = useForm()
  const history = useHistory();

  const onSubmit = (data) => {
      console.log(data)
      axios.post("http://localhost:8081/twitter/register", data).then(response => {
        console.log(response)
        if(response.data === 'Success')
            history.push("/twitter/login")
        else
            alert("Введите верные данные!\nЗарегистироваться снова.")
      })
  }

  return (
    <Container component="main" maxWidth="xs" className="registration">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <AccountCircleIcon/>
        </Avatar>
        <Typography component="h1" variant="h5">
            Создайте новый аккаунт
        </Typography>
        <form className={classes.form} onSubmit={handleSubmit(onSubmit)}>
        <TextField
            variant="outlined"
            margin="normal"
            inputRef={register({ required: true})}
            required
            fullWidth
            id="displayName"
            label="Имя"
            name="displayName"
            autoFocus
          />
          {errors.displayName && <span>This field is required</span>}
          <TextField
            variant="outlined"
            margin="normal"
            inputRef={register}
            fullWidth
            id="avatar"
            label="Ссылка на аватарку"
            name="avatar"
          />
          <TextField
            variant="outlined"
            margin="normal"
            inputRef={register({ required: true})}
            required
            fullWidth
            id="userName"
            label="Никнейм"
            name="userName"
          />
          {errors.userName && <span>This field is required</span>}
          <TextField
            variant="outlined"
            margin="normal"
            inputRef={register({ required: true})}
            required
            fullWidth
            id="emailId"
            label="Почта"
            type="email"
            name="emailId"
            autoComplete="email"
          />
          {errors.emailId && <span>This field is required</span>}
          <TextField
            variant="outlined"
            margin="normal"
            inputRef={register({ register: true})}
            required
            fullWidth
            name="password"
            label="Пароль"
            type="password"
            id="password"
            autoComplete="current-password"
          />
          {errors.password && <span>This field is required</span>}
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
          >
            Зарегистироваться
          </Button>
          <Grid container>
            <Grid item>
              <Link href="/twitter/login" variant="body2">
                Войти в существующий аккаунт
              </Link>
            </Grid>
          </Grid>
        </form>
      </div>
    </Container>
  );
}