import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let token = null;
    
      if (state.url == '/login'  || state.url == '/register' || state.url == '/') {
        return true;
      }

      token = sessionStorage.getItem('token');

      if (state.url == '/logout' && !token) {
        return this.router.parseUrl('');
      }

      if (state.url == '/devcorn/**' && !token) {
        return this.router.parseUrl('/login');
      }

      if (state.url == '/messages' && !token) {
        return this.router.parseUrl('');
      }

      if (state.url == '/mentor' && token) {
        let role = localStorage.getItem('user-role');
        if(role != "MENTOR") {
          return this.router.parseUrl('');
        }
      }

      if (!token) {
        return this.router.parseUrl('/login');
      }
    
    return true;
  }
  
}
