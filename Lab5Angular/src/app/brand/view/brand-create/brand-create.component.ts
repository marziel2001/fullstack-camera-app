import {Component, OnInit} from '@angular/core';
import {BrandService} from "../../service/brand.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BrandForm} from "../../model/brand-form";

@Component({
  selector: 'app-brand-create',
  templateUrl: './brand-create.component.html',
  styleUrls: ['./brand-create.component.css', '../../../forms.css']
})
export class BrandCreateComponent implements OnInit {

    brand: BrandForm = {
        // id: '',
        name: '',
        yearOfEst: 0,
        country: '',
        brandValueDollars: 0
    }

      constructor(
        private brandService: BrandService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit(): void {
    }

    onSubmit(): void {
        this.brandService.putBrand(this.brand!)
            .subscribe(() => this.router.navigate(['/brands']));
    }

}
