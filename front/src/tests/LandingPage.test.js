import { shallow } from 'enzyme';
import LandingPage from './LandingPage';
import { render, screen } from '@testing-library/react';

test('landingPage', () => {
    const component = shallow(<LandingPage/>);
    const insideComponent = component.find('.landingPage')
    expect(insideComponent.length).toBe(1);
})

test('renders welcome to twitter', () => {
    render(<LandingPage/>);
    const linkElement = screen.getByText(/Добро пожаловать!/i);
    expect(linkElement).toBeInTheDocument();
});  

test('renders click on buttons', () => {
    render(<LandingPage/>);
    const linkElement = screen.getByText(/Нажми на нижние кнопки/i);
    expect(linkElement).toBeInTheDocument();
});  