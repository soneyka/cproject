import React, {useState, useEffect} from 'react'
import ChatBubbleIcon from '@material-ui/icons/ChatBubble';
import FavoriteBorderIcon from '@material-ui/icons/FavoriteBorder';
import EditIcon from '@material-ui/icons/Edit';
import DeleteIcon from '@material-ui/icons/Delete';
import axios from 'axios';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import TextField from '@material-ui/core/TextField';

function UserPostFooterIcons({tweetId, likes}) {

    const [openDelete, setOpenDelete] = useState(false);
    const [openUpdate, setOpenUpdate] = useState(false);
    const [tweetBody, setTweetBody] = useState('');
    const [tweetImage, setTweetImage] = useState('');
    const [tweetLikes, setTweetLikes] = useState(0);

    const handleDeleteClickOpen = () => {
        setOpenDelete(true);
    };

    const handleDeleteClose = () => {
        setOpenDelete(false);
    };

    const handleUpdateClickOpen = () => {
        setOpenUpdate(true);
    };

    const handleUpdateClose = () => {
        setOpenUpdate(false);
    };

    const deleteTweet = (tweetId) => {
        console.log(tweetId+"deleted")
        axios.delete(`http://localhost:8081/twitter/tweets/${tweetId}`)
        setOpenDelete(false)
        window.location.reload()
    }

    const updateTweet = (tweetId) => {
        console.log(tweetBody+"-------"+tweetImage)
        axios.put(`http://localhost:8081/twitter/tweets/${tweetId}`, {tweetBody: tweetBody, tweetImage: tweetImage})
        setOpenUpdate(false)
        window.location.reload()
    }

    const changeTweetBodyHandler = (e) => {
        setTweetBody(e.target.value)
    }

    const changeTweetImageHandler = (e) => {
        setTweetImage(e.target.value)
    }

    useEffect(() => {
        axios.get(`http://localhost:8081/twitter/tweets/${tweetId}`).then(response => {
            let tweet = response.data;
            setTweetBody(tweet.tweetBody)
            setTweetImage(tweet.tweetImage)
            setTweetLikes(tweet.likes)
        })
    }, [])

    return (
        <React.Fragment>
            <ChatBubbleIcon fontSize="small"/>
            <span style={{display: 'flex', alignItems: 'center', flexWrap: 'wrap'}}>
                <FavoriteBorderIcon fontSize="small" style={{color: 'red'}}/>
                <p style={{fontSize: '14px', fontWeight: '600' , color: 'gray', marginLeft: '5px'}}>{tweetLikes > 0 && (tweetLikes === 1 ? `${tweetLikes} like` : `${tweetLikes} likes`)}</p>
            </span>
            <EditIcon fontSize="small" onClick={handleUpdateClickOpen} style={{cursor:'pointer'}}/>
            <DeleteIcon fontSize="small" onClick={handleDeleteClickOpen} style={{cursor: 'pointer'}}/>

            <Dialog
            open={openDelete}
            onClose={handleDeleteClose}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description"
            maxWidth="sm" 
            fullWidth={true}
            >
                <DialogTitle id="alert-dialog-title">{"Delete Tweet?"}</DialogTitle>
                <DialogContent>
                    <DialogContentText id="alert-dialog-description">
                    Это невозможно отменить, и оно будет удалено из вашего профиля, временной шкалы любых учетных записей
которые следуют за вами, а также из результатов поиска в Twitter.
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleDeleteClose} color="primary">
                    Отмена
                    </Button>
                    <Button onClick={() => deleteTweet(tweetId)} color="secondary" autoFocus>
                    Удалить
                    </Button>
                </DialogActions>
            </Dialog>


            <Dialog open={openUpdate} onClose={handleUpdateClose} aria-labelledby="form-dialog-title" maxWidth="sm" fullWidth={true}>
                <DialogTitle id="form-dialog-title">Изменить твит?</DialogTitle>
                <DialogContent>
                    {/* <DialogContentText>
                    To subscribe to this website, please enter your email address here. We will send updates
                    occasionally.
                    </DialogContentText> */}
                    <TextField
                    autoFocus
                    margin="dense"
                    id="tweet"
                    label="Твит"
                    type="text"
                    value={tweetBody}
                    fullWidth
                    onChange={changeTweetBodyHandler}
                    />
                    <TextField
                    margin="dense"
                    id="tweetImage"
                    label="Картинка твита"
                    type="text"
                    value={tweetImage}
                    fullWidth
                    onChange={changeTweetImageHandler}
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleUpdateClose} color="primary">
                    Закрыть
                    </Button>
                    <Button onClick={() => updateTweet(tweetId)} style={{color: 'green'}} autoFocus>
                    Изменить
                    </Button>
                </DialogActions>
            </Dialog>

        </React.Fragment>
    )
}

export default UserPostFooterIcons
