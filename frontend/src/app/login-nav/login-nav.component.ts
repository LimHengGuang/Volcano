import { Component, OnInit } from '@angular/core';
import { Util } from '../utilities/util';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';  
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-login-nav',
  templateUrl: './login-nav.component.html',
  styleUrls: ['./login-nav.component.css']
})
export class LoginNavComponent implements OnInit {

  user: Object;
  team: Object;
  currentRoute = '';

  constructor(public router: Router) { 
    this.router = router;
  }

  refreshNavBar() {
  	this.user = Util.getLoggedInUser();
    this.team = Util.getCurrentTeam();
    // If we're logged in, but there's no team, the user needs
    // to pick one
    if (this.user != null && this.team == null && this.router.url != '/teams') {
      this.router.navigate(['teams']);
      Util.writeSuccess("Login successful!");
    }

    // Clear the system output when you switch routes
    if ( String(this.router.url).valueOf() != String(this.currentRoute).valueOf() ) {
      document.getElementById("systemOutput").style.display = 'none';
    } 
    this.currentRoute = this.router.url;
  }


  ngOnInit() {
  	this.refreshNavBar();
  	setInterval(() => { this.refreshNavBar() }, 1000);
  }

  logout() {
  	Util.logOut();
  	this.refreshNavBar();
  	Util.writeSuccess("Logged out successfully");
  }

}
